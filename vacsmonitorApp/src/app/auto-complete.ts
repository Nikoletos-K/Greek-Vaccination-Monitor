// import {Component, OnInit} from '@angular/core';
// import {FormControl} from '@angular/forms';
// import {Observable} from 'rxjs';
// import {map, startWith} from 'rxjs/operators';

// /**
//  * @title Highlight the first autocomplete option
//  */
// @Component({
//   selector: 'app-root',
//   templateUrl: './app.component.html',
//   styleUrls: ['./app.component.css'],
// })

// export class AutocompleteAutoActiveFirstOptionExample implements OnInit {
//   public myControl = new FormControl();
//   public options: string[] = ['One', 'Two', 'Three'];
//   public filteredOptions!: Observable<string[]>;

//   ngOnInit() {
//     this.filteredOptions = this.myControl.valueChanges.pipe(
//       startWith(''),
//       map(value => this._filter(value))
//     );
//   }

//   private _filter(value: string): string[] {
//     const filterValue = value.toLowerCase();

//     return this.options.filter(option => option.toLowerCase().includes(filterValue));
//   }
// }


/**  Copyright 2021 Google LLC. All Rights Reserved.
    Use of this source code is governed by an MIT-style license that
    can be found in the LICENSE file at http://angular.io/license */