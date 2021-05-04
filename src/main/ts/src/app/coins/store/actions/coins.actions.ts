import {createAction, props} from '@ngrx/store';
import {Coin} from '../../coin';


export const ShowList = createAction(
  '[Coin] Show CoinList'
);

export const loadCoins = createAction(
  '[Coins] load'
);
export const loadCoinsSuccess = createAction(
  '[Coins] load Success',
  props<{ coins: Coin[] }>()
);
export const loadCoinsFailure = createAction(
  '[Coins] load Failed',
  props<{ error: string }>()
);
