import React from 'react'


class NumberName extends React.Component {

    constructor(props) {
        super(props);
        console.log(props);
        this.state = {
            numberName: "Insert a number please",
            className: ""
        };
    }

    updateState = (response) => {
        if (response.status === "NOT_ACCEPTABLE") {
            this.setState({ numberName: response.message, className: "alert alert-danger" });
        } else {
            this.setState({ numberName: response.result.word, className: "alert alert-primary"})
        }
    }

    render() {
        return <div className={this.state.className} role="alert"><h1>{this.state.numberName}</h1></div>
    }


}

export default NumberName