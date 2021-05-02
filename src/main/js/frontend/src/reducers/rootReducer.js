import { combineReducers } from 'redux'

import coinReducer from './coinReducer'

const rootReducer = combineReducers({
  // Define a top-level state field named `todos`, handled by `todosReducer`
  coins: coinReducer
})

export default rootReducer