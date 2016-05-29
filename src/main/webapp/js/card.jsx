import React from "react";

export default class Card extends React.Component {
    
    render() {
        return <section className="cardContainer">
            <div id="card" className={this.props.cardState}>
                <figure className="question">{this.props.question}</figure>
                <figure className="answer">{this.props.answer}</figure>
            </div>
        </section>
    }
}