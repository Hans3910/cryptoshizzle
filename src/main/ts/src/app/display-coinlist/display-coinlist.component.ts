import { Component, OnInit } from '@angular/core';
import {Coin} from '../coin';
import {CoinService} from '../coin.service';

@Component({
  selector: 'app-display-coinlist',
  templateUrl: './display-coinlist.component.html',
  styleUrls: ['./display-coinlist.component.css']
})
export class DisplayCoinlistComponent implements OnInit {
  coins: Coin[];

  constructor(private coinService: CoinService) { }

  ngOnInit(): void {
    this.getAllCoins();
  }

  public getAllCoins(): void {
    this.coinService.getAllCoins()
      .subscribe(coinList => this.coins = coinList);
  }
}
