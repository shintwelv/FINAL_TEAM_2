import logo from "./logo.svg";
import "./App.css";
import axios from "axios";

function App() {
  const getArticleURL = "/review/reply/view.do?articleId=2";
  const getReplyURL = "";

  function getArticles() {
    axios.get(getArticleURL).then((res) => {
      console.log(res);
    });
  }

  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
          {getArticles()}
        </a>
      </header>
    </div>
  );
}

export default App;
