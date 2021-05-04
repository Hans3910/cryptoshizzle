import {createFeatureSelector, createReducer, createSelector, on} from '@ngrx/store';
import * as CoinsActions from '../actions/coins.actions';
import {CoinState, initialState} from '../state/coin.state.';

export const coinReducer = createReducer<CoinState>(
  initialState,
on(CoinsActions.loadCoinsSuccess, (state, action): CoinState => {
  return {
    ...state,
    coins: action.coins,
    error: ''
  };
}),
  on(CoinsActions.loadCoinsFailure, (state, action): CoinState => {
    return {
      ...state,
      coins: [],
      error: action.error
    };
  })
);
