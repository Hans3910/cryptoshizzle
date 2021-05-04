import {Component, OnInit} from '@angular/core';
import {Coin} from '../coin';
import {CoinService} from '../service/coin.service';
import {Observable} from 'rxjs';
import {Store} from '@ngrx/store';
import * as CoinsActions from '../store/actions/coins.actions';

import {State} from '../store/state/coin.state.';
import {getCoins} from '../store/selectors/coins.selectors';


@Component({
  selector: 'app-display-coinlist',
  templateUrl: './coin-list.component.html',
  styleUrls: ['./coin-list.component.css']
})
export class CoinListComponent implements OnInit {
  coins$: Observable<Coin[]>;

  constructor(private coinService: CoinService,
              private store: Store<State>) {
  }

  ngOnInit(): void {
    this.coins$ = this.store.select(getCoins);
    this.store.dispatch(CoinsActions.loadCoins());
  }

  // public getAllCoins(): void {
  //   this.coinService.getAllCoins()
  //     .subscribe(coinList => this.coins = coinList);
  // }
}
