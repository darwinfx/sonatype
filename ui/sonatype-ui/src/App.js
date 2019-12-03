import React, { Component } from 'react';
import NumberName from './components/NumberName';
import InputToConvert from './components/InputToConvert';

class App extends Component {
  constructor(props) {
    super(props);
    this.numberNameElement = React.createRef();
  }

  convertNumber = (event) => {
    if (event.target.value !== "") {
      fetch('http://localhost:8080/converter?value=' + event.target.value)
        .then(res => res.json())
        .then((data) => {
          console.log(data);
          this.setState({ response: data });
          this.numberNameElement.current.updateState(data);
        })
        .catch(console.log)
    } else {
      this.numberNameElement.current.updateState({result:{word:"Insert a number please"}})
    }
  }

  render() {
    return (
      <div className="container">
        <div className="row text-center"><div className="col"><NumberName ref={this.numberNameElement} /></div></div>
        <div className="row"><div className="col"><InputToConvert requestUrl={this.convertNumber} /></div></div>
      </div>
    )
  }
}

export default App;