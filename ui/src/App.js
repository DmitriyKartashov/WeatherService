import React from 'react';

class SearchForm extends React.Component {
  constructor(props) {
    super(props);
    this.state = {value: ''};

    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleChange(event) {
    this.setState({value: event.target.value});
  }

  handleSubmit(event) {
    fetch('http://localhost:8080/weather?city=' + this.state.value)
      .then(response => response.json())
      .then((jsonData) => {
        // jsonData is parsed json object received from url
        console.log(jsonData)

        alert('The temperature is: ' + jsonData.temperature);
      })
      .catch((error) => {
        // handle your errors here
        console.error(error)
      })
    event.preventDefault();
  }

  render() {
    return (
      <form onSubmit={this.handleSubmit}>
        <label>
          Name:
          <input type="text" value={this.state.value} onChange={this.handleChange} />
        </label>
        <input type="submit" value="Submit" />
      </form>
    );
  }
}

class App extends React.Component {
   render() {
      return (
         <div>
            <h1>Weather service</h1>
            <h2>Please enter city</h2>
            <SearchForm/>
         </div>
      );
   }
}
export default App;