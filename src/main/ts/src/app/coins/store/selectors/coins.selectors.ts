import {createFeatureSelector, createSelector} from '@ngrx/store';
import {CoinState} from '../state/coin.state.';

const getCoinState = createFeatureSelector<CoinState>('coins');

export const getCoins = createSelector(
  getCoinState,
  state => state.coins
);
