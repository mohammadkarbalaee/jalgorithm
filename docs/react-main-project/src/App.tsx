import React from 'react';
import logo from './jalgorithm.jpg';
import './App.css';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Jalgorithm, comming soon....
        </p>
        <a
          className="App-link"
          href="https://github.com/muhammadkarbalaee/jalgorithm"
          target="_blank"
          rel="noopener noreferrer"
        >
          Jalgorithm's github repo
        </a>
      </header>
    </div>
  );
}

export default App;
