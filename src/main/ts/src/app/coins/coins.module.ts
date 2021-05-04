import { NgModule } from '@angular/core';
import { StoreModule } from '@ngrx/store';
import {SharedModule} from '../shared/shared.module';
import {CoinListComponent} from './display-coinlist/coin-list.component';
import {EffectsModule} from '@ngrx/effects';
import {CoinEffects} from './store/effects/coin-effects.service';
import {coinReducer} from './store/reducer/coins.reducer.';

@NgModule({
  imports: [
    SharedModule,
    StoreModule.forFeature('coins', coinReducer),
    EffectsModule.forFeature([CoinEffects])
  ],
  declarations: [
    CoinListComponent
  ]
})
export class CoinsModule { }
