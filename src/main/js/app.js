const React = require('react');
const ReactDOM = require('react-dom');
//const client = require('./company');

class App extends React.Component {

    constructor(props) {
        super(props);
        this.state = {companies: []};
    }

     componentDidMount() {
     //   client({method: 'GET', path: '/companies'}).done(response => {
     //         this.setState({employees: response.entity._embedded.companies});
     // });
     //     var self = this;
     //     $.ajax({
     //         url: "http://localhost:8080/companies"
     //     }).then(function (data) {
     //         self.setState({companies: data._embedded.companies});
     //     });
         fetch("http://localhost:8080/companies")
             .then(result => result.json())
             .then(companies => this.setState({companies: companies}))
     }

    render() {
        return (
            <CompanyList companies={this.state.companies}/>
    )
    }
}

class CompanyList extends React.Component{
    render() {
        var self = this;
        var companies = this.props.companies.map(company =>
            <Company key={company.companyId} company={company}/>
        );
        return (
            <table>
                <tbody>
                <tr>
                    <th>Company ID</th>
                    <th>Name</th>
                    <th>City</th>
                </tr>
                {companies}
                </tbody>
            </table>
        )
    }
}

class Company extends React.Component{

    render() {
        return (
            <tr>
                <td>{this.props.company.companyId}</td>
                <td>{this.props.company.name}</td>
                <td>{this.props.company.city}</td>

            </tr>
        )
    }
}

class Button extends React.Component {
    constructor(props) {
        super(props);
         this.handleClick = this.handleClick.bind(this);
    }

    handleClick() {
        console.log("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!")
    }

    render() {
        return (
            <button onClick={this.handleClick}>
uppp            Button
            </button>
        );
    }
}

ReactDOM.render(
    <App />,
    document.getElementById('react')
)