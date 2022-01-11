import React from 'react';
import logo from './jalgorithm.jpg';
import './App.css';
import Draggable from 'react-draggable';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <Draggable>
          <div>
            <img src={logo} className="App-logo" alt="logo" />
          </div>
        </Draggable>
        drag me!🙄
        <p>
          <code>Jalgorithm</code>
          <br/>
          the DSA library to beat them all.
          <br/>
          coming soon....
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
