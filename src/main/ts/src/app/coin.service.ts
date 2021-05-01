import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {Coin} from './coin';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CoinService {
  private readonly getCoinUrl: string;

  constructor(private url: HttpClient) {
    this.getCoinUrl = 'http://localhost:8081/coins';
  }

  public getAllCoins(): Observable<Coin[]> {
    return this.url.get<Coin[]>(this.getCoinUrl);
  }
}

