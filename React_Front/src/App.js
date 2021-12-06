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
  const [board, setBoard] = useState('')
  const [userState, setUserState] = useState('')
  const [process, setProcess] = useState('')
  const [userInfo, setUserInfo] = useState(null)

  return (
    <div className="page-container">
      <div className="contents-wrapper">
        <Header
          login={login}
          setLogin={setLogin}
          setUserState={setUserState}
          setBoard={setBoard}
          userInfo={userInfo}
          setUserInfo={setUserInfo}
        />
        <Switch>
          <Route
            path="/"
            exact={true}
            render={() => <Main setBoard={setBoard} />}
          />
          <Route
            path="/festival"
            render={() => <Festival setBoard={setBoard} />}
          />
          <Route path="/festivaldetail" component={Festival_Detail} />
          <Route
            path={['/notice', '/review', '/free']}
            render={() => (
              <Board
                setBoard={setBoard}
                board={board}
                process={process}
                setProcess={setProcess}
                login={login}
              />
            )}
          />
          <Route
            path="/Read/:articleNo"
            render={() => (
              <Read
                board={board}
                userInfo={userInfo}
                login={login}
                setProcess={setProcess}
              />
            )}
          />
          <Route
            path={['/UserInfo', '/SignUp']}
            render={() => (
              <UserInfo
                userState={userState}
                userInfo={userInfo}
                setLogin={setLogin}
              />
            )}
          />
          <Route
            path={['/write', '/update/:articleNo']}
            render={() => (
              <Write
                login={login}
                board={board}
                userInfo={userInfo}
                process={process}
              />
            )}
          />
          <Route render={({ location }) => <NotFound />} />
        </Switch>
      </div>
      <Footer />
    </div>
  )
}

export default App
