import React from 'react';
import logo from './jalgorithm.jpg';
import './App.scss';
import Draggable from 'react-draggable';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <div id={'logo-box'}>
          <Draggable>
            <div>
              <img src={logo} className="App-logo" alt="logo" />
            </div>
          </Draggable>
        </div>
        drag me!🙄
        <p>
          <code>Jalgorithm</code>
          <br/>
          We offer what Java developers need and deserve💪
          <br/>
          v2.0.0 coming soon....
        </p>
        <a
          className="App-link"
          href="https://github.com/muhammadkarbalaee/jalgorithm"
          target="_blank"
          rel="noopener noreferrer"
        >
          <img src={'https://www.vectorlogo.zone/logos/github/github-ar21.svg'} width={200} alt={'github'}/>
          <br/>
          Jalgorithm's github repo
        </a>
      </header>
    </div>
  );
}

export default App;
