import { NgModule } from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {DisplayCoinlistComponent} from './display-coinlist/display-coinlist.component';

const routes: Routes = [
  {path: '', redirectTo: '/coins', pathMatch: 'full'},
  { path: 'coins', component: DisplayCoinlistComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
