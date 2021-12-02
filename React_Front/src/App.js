import { Route, Switch } from 'react-router-dom'
import './normalize.scss'
import './app.scss'
import Main from './Pages/Main'
import NoticeRead from './Pages/NoticeRead'
import Festival from './Pages/Festival'
import Festival_Detail from './Pages/FestivalDetail'
import ReviewRead from './Pages/ReviewRead'
import FreeRead from './Pages/FreeRead'
import UserInfo from './Pages/UserInfo'
import Header from './components/Header/Header'
import Footer from './components/Footer'
import NotFound from './Pages/NotFound'
import Write from './components/Write'
import Update from './components/Update'
import { useState } from 'react'
import Board from './Pages/Board'
import Read from './Pages/Read'

const App = () => {
  const [login, setLogin] = useState(false)
  const [nickName, setNickName] = useState('')
  const [board, setBoard] = useState('')
  const [userState, setUserState] = useState('')

  return (
    <div className="page-container">
      <div className="contents-wrapper">
        <Header
          login={login}
          setLogin={setLogin}
          nickName={nickName}
          setUserState={setUserState}
          setBoard={setBoard}
        />
        <Switch>
          <Route path="/" component={Main} exact={true} />
          <Route
            path="/festival"
            render={() => <Festival setBoard={setBoard} />}
          />
          <Route path="/festivaldetail" component={Festival_Detail} />
          <Route
            path={['/notice', '/review', '/free']}
            render={() => <Board setBoard={setBoard} board={board} />}
          />
          <Route path="/Read" render={() => <Read board={board} />} />
          <Route path="/noticeread" component={NoticeRead} />
          <Route path="/reviewread" component={ReviewRead} />
          <Route path="/freeread" component={FreeRead} />
          <Route
            path={['/UserInfo', '/SignUp']}
            render={() => <UserInfo userState={userState} />}
          />
          <Route
            path="/write"
            render={() => <Write login={login} board={board} />}
          />
          <Route path="/update" component={Update} />
          <Route render={({ location }) => <NotFound />} />
        </Switch>
      </div>
      <Footer />
    </div>
  )
}

export default App
