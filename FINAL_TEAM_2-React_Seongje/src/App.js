import { Route, Switch } from 'react-router-dom'
import './normalize.scss'
import './app.scss'
import Main from './Pages/Main'
import Notice from './Pages/Notice'
import NoticeRead from './Pages/NoticeRead'
import Festival from './Pages/Festival'
import Festival_Detail from './Pages/FestivalDetail'
import Review from './Pages/Review'
import ReviewRead from './Pages/RevieRead'
import Free from './Pages/Free'
import FreeRead from './Pages/FreeRead'
import UserInfo from './Pages/UserInfo'
import Header from './components/Header/Header'
import Footer from './components/Footer'
import SideBar from './components/SideBar'
import Update from './Pages/Update'
import Write from './Pages/Write'
import NotFound from './Pages/NotFound'

const App = () => {
  return (
    <div className="page-container">
      <div className="contents-wrapper">
        <Header />
        <Switch>
          <Route path="/" component={Main} exact={true} />
          <Route path="/notice" component={Notice} />
          <Route path="/noticeread" component={NoticeRead} />
          <Route path="/festival" component={Festival} />
          <Route path="/festivaldetail" component={Festival_Detail} />
          <Route path="/review" component={Review} />
          <Route path="/reviewread" component={ReviewRead} />
          <Route path="/free" component={Free} />
          <Route path="/freeread" component={FreeRead} />
          <Route path="/sidebar" component={SideBar} />
          <Route path="/userinfo" component={UserInfo} />
          <Route path="/write" component={Write} />
          <Route path="/update" component={Update} />
          <Route render={({ location }) => <NotFound />} />
        </Switch>
      </div>
      <Footer />
    </div>
  )
}

export default App
