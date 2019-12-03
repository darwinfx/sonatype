import React from 'react'

class InputToConvert extends React.Component {
    constructor(props) {
        super(props);
        this.requestUrl = props.requestUrl.bind(this);
        console.log(props);
    }

    render() {
        return <div className="input-group input-group-sm mb-3">
            <div className="input-group-prepend">
                <span className="input-group-text" id="inputGroup-sizing-default">Please insert the number to convert:</span>
            </div>
            <input type="text" className="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" onChange={this.requestUrl} />
        </div>
    }
}

export default InputToConvert