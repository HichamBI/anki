import React from "react";
import Card from "./card.jsx";
import Button from "./button.jsx";
import $ from "jquery";

export default class Game extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            question: "",
            answer: "",
            cardState: ""
        }
    }

    componentDidMount() {
        $.ajax({
            url: "http://localhost:8080/anki/startGame",
            dataType: 'json',
            success: function (data) {
                this.setState({
                    answer: data.answer,
                    question: data.question
                });
            }.bind(this),
            error: function (xhr, status, err) {
                console.error(this.props.url, status, err.toString());
            }.bind(this)
        });
    }

    submitEvaluation(evaluation) {
        if (this.state.cardState === "flipped") {
            this.state.cardState = '';
        }

        $.ajax({
            type: "POST",
            dataType: 'json',
            url: "http://localhost:8080/anki/submitEvaluation",
            data: {"evaluation": evaluation},
            success: function (data) {
                this.setState({
                    answer: data.answer,
                    question: data.question
                });
            }.bind(this),
            error: function (xhr, status, err) {
                console.error(this.props.url, status, err.toString());
            }.bind(this)
        });
    }

    flipCard() {
        this.setState({
            cardState: this.state.cardState === "flipped" ? '' : "flipped"
        });
    }

    render() {
        return <div>
            <Card question={this.state.question} answer={this.state.answer} cardState={this.state.cardState}/>

            <div className="evaluationButtons">
                <Button text="Red" onClick={this.submitEvaluation.bind(this, "RED")}/>
                <Button text="Green" onClick={this.submitEvaluation.bind(this, "GREEN")}/>
                <Button text="Orange" onClick={this.submitEvaluation.bind(this, "ORANGE")}/>
            </div>
            <div className="flipButton">
                <Button text="Flip Card" onClick={this.flipCard.bind(this)}/>
            </div>
        </div>
    }
}