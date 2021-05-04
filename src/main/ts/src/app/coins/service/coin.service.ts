import { Injectable } from '@angular/core';
import {Observable, throwError} from 'rxjs';
import {Coin} from '../coin';
import {HttpClient} from '@angular/common/http';
import {catchError, tap} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class CoinService {
  private readonly getCoinUrl: string;

  constructor(private url: HttpClient) {
    this.getCoinUrl = 'http://localhost:8081/coins';
  }

  public getAllCoins(): Observable<Coin[]> {
    return this.url.get<Coin[]>(this.getCoinUrl).pipe(
      tap(data => console.log(JSON.stringify(data))),
      catchError(this.handleError)
    );
  }

  // tslint:disable-next-line:typedef
  private handleError(err: any) {
    // in a real world app, we may send the server to some remote logging infrastructure
    // instead of just logging it to the console
    let errorMessage: string;
    if (err.error instanceof ErrorEvent) {
      // A client-side or network error occurred. Handle it accordingly.
      errorMessage = `An error occurred: ${err.error.message}`;
    } else {
      // The backend returned an unsuccessful response code.
      // The response body may contain clues as to what went wrong,
      errorMessage = `Backend returned code ${err.status}: ${err.body.error}`;
    }
    console.error(err);
    return throwError(errorMessage);
  }
}

