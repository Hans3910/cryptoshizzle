import {Injectable} from '@angular/core';
import {Actions, createEffect, ofType} from '@ngrx/effects';
import {CoinService} from '../../service/coin.service';
import * as CoinsActions from '../actions/coins.actions';
import {catchError, map, mergeMap} from 'rxjs/operators';
import {of} from 'rxjs';

@Injectable()
export class CoinEffects {
  constructor(private actions$: Actions,
              private coinService: CoinService) {
  }

  loadCoins$ = createEffect(() => {
    return this.actions$.pipe(
      ofType(CoinsActions.loadCoins),
      mergeMap(action => this.coinService.getAllCoins().pipe(
        map(coins => CoinsActions.loadCoinsSuccess({coins})),
        catchError(error => of(CoinsActions.loadCoinsFailure({error})))
      ))
    );
  });
}
