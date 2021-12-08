import { Route, Switch } from 'react-router-dom'
import './normalize.scss'
import './app.scss'
import Main from './Pages/Main'
import Festival from './Pages/Festival'
import UserInfo from './Pages/UserInfo'
import Header from './components/Header/Header'
import Footer from './components/Footer'
import NotFound from './Pages/NotFound'
import Write from './components/Write'
import { useState } from 'react'
import Board from './Pages/Board'
import Read from './Pages/Read'
import Admin from './Pages/Admin'
import FestivalDetail from './Pages/FestivalDetail'

const App = () => {
  const [login, setLogin] = useState(false)
  const [board, setBoard] = useState('')
  const [userState, setUserState] = useState('')
  const [process, setProcess] = useState('')
  const [userInfo, setUserInfo] = useState({
    Image: null,
    userId: '',
    userPw: '',
    userName: '',
    nickName: '',
    birth: null,
    gender: '',
    email: '',
    phoneNumber: '',
    userBasicAddress: '',
    userDetailAddress: '',
    enabled: 0,
    admin: 'N',
  })

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
          <Route path={'/Admin'} render={() => <Admin />} exact />
          <Route
            path="/festivalDetail/:articleNo"
            render={() => <FestivalDetail />}
          />
          <Route render={({ location }) => <NotFound />} />
        </Switch>
      </div>
      <Footer />
    </div>
  )
}

export default App
