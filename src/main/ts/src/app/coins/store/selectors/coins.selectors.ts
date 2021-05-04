import {createFeatureSelector, createSelector} from '@ngrx/store';
import {CoinState} from '../state/coin.state.';

const getCoinState = createFeatureSelector<CoinState>('coins');

export const getCoins = createSelector(
  getCoinState,
  state => state.coins
);

export const getShowCoinList = createSelector(
  getCoinState,
  state => state.showCoinList
);
