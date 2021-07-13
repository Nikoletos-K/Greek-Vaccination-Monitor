import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Region } from './region';
import { RegionService } from './region.service';

import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';
import {MatTableDataSource} from '@angular/material/table';

import {FormControl, ReactiveFormsModule} from '@angular/forms';
import {Observable} from 'rxjs';
import {map, startWith} from 'rxjs/operators';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  public regions!: Region[];
  public region_names!: string[];


  constructor(private regionService: RegionService){}

  ngOnInit() {
    this.getRegions();
    
  }
  
  public getRegions(): void {
    this.regionService.getRegions().subscribe(
      (response: Region[]) => {
        this.regions = response;
      },
      (error: HttpErrorResponse) =>  {
        alert(error.message);
      }
    );
  }

  public searchRegion(key: String): void {

    const results: Region[] = []
    for(const region of this.regions) {
      if (region.name.toLowerCase().indexOf(key.toLowerCase()) !== -1) {
        results.push(region)
      }
    }

    this.regions = results
    if (results.length == 0 || !key) {
      this.getRegions();
    }
  }

}
