import * as AppState from '../../../state/state';
import {Coin} from '../../coin';

export const key = 'feature';

export interface State extends AppState.State {
  coins: CoinState;
}

export interface CoinState {
  showCoinList: boolean;
  coins: Coin[];
  error: string;
}

export const initialState: CoinState = {
  showCoinList: true,
  coins: [],
  error: ''
};
