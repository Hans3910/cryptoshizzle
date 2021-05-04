import { NgModule } from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {CoinListComponent} from './coins/display-coinlist/coin-list.component';

const routes: Routes = [
  {path: '', redirectTo: '/coins', pathMatch: 'full'},
  { path: 'coins', component: CoinListComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
