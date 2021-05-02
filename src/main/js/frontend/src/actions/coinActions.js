const BASE_URL = 'http://localhost:8080';
export const FETCH_COINS_BEGIN   = 'FETCH_COINS_BEGIN';
export const FETCH_COINS_SUCCESS = 'FETCH_COINS_SUCCESS';
export const FETCH_COINS_FAILURE = 'FETCH_COINS_FAILURE';

export const fetchCoinsBegin = () => ({
  type: FETCH_COINS_BEGIN
});

export const fetchCoinsSuccess = coins => ({
  type: FETCH_COINS_SUCCESS,
  payload: { coins }
});

export const fetchCoinsFailure = error => ({
  type: FETCH_COINS_FAILURE,
  payload: { error }
});

export function fetchCoins() {
    return dispatch => {
      dispatch(fetchCoinsBegin());
      return fetch(BASE_URL + "/coins")
        .then(handleErrors)
        .then(res => res.json())
        .then(coins => {
          dispatch(fetchCoinsSuccess(coins));
          return coins;
        })
        .catch(error => dispatch(fetchCoinsFailure(error)));
    };
  }
  
  // Handle HTTP errors since fetch won't.
  function handleErrors(response) {
    if (!response.ok) {
      throw Error(response.statusText);
    }
    return response;
  }
  
  