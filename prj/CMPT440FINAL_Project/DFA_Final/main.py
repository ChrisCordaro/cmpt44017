#Chris Cordaro
#DFA_Final project
#5/8/2017
#Music and Mood Determination
#Description:
#   This is a simple DFA that takes in a user input regarding their mood for the past five days
#   It then runs through it's transition table in order to determine the users mood. If the user
#   is determined to be in a Happy state, all is well and the DFA reports back to the user. If the
#   user is determined to be in any state other than happy, the DFA reports back to tell the user
#   what type of music he/she should listen to.
#

import re
import os

testProgramCheck = False

class initialize:
    currState = None
    test = 1
    programContinueCheck = False

    while True:
        #Takes in user input. General directions will be found in a ReadMe file
        #checks input to ensure it is exactly 5 characters and only contains h f or s
        feelings = raw_input("Please enter how you have been feeling for the past 5 days")
        if not re.match("^[a-z]*$", feelings):
            print "Error! Only letters h s f allowed!"
            continue
        elif len(feelings) > 5:
            print "Error! Please enter only 5 values"
        elif len(feelings) < 5:
            print "Error! Please enter 5 values"
        else:
            #input is good continue the program
            feelingsList = list(feelings)
            testProgramCheck = True
            break

    #5 tuple initilization of DFA
    def __init__(self, states, alphabet, delta, startState, acceptState):
        self.states = states
        self.alphabet = alphabet
        self.transition_function = delta
        self.start_state = startState
        self.accept_states = acceptState
        self.currState = startState

        return

    # Move to a new state given an input
    def transitionOnUserInput(self, input_value):
        #Check transitions for any rule that is accepted with the give input
        if ((self.currState, input_value) not in self.transition_function.keys()):
            self.currState = None
            return

        # else, the current state becomes whatever is defined in the transition_function.
        self.currState = self.transition_function[(self.currState, input_value)]
        return

    def checkAccepted(self):
        if(self.currState in accept_state):
            print "YOU ARE HAPPY"
        if(not self.currState in accept_state):

            print "YOU ARE NOT HAPPY..."
           # print self.current_state
            if(self.currState == 0):
                print "YOU ENDED IN NEUTRAL STATE. The easiest way to get happy is to listen to a happy song :)"
            if (self.currState == 2):
                print "YOU ENDED IN SAD STATE. The easiest way to get happy is to listen to a focused and then a happy song :)"
            if (self.currState == 3):
                print "YOU ENDED IN FOCUS STATE. The easiest way to get happy is to listen to a happy song :)"

    # Reset to the start state
    def setInitialState(self):
        self.currState = self.start_state
        return

    def __str__(self):
       return "The current_state is: " + self.currState


    def run(self, input_list):
        self.setInitialState()
        for inp in input_list:
            self.transitionOnUserInput(inp)

            continue
        return    self.checkAccepted()


#Neutral Happy Sad Focused
#Neural = 0
#Happy = 1
#Sad = 2
#Focus = 3

states = {0, 1, 2, 3}
alphabet = {'h', 's', 'f'}

transitions_map = dict()
transitions_map[(0, 'h')] = 1
transitions_map[(0, 's')] = 2
transitions_map[(0, 'f')] = 3

transitions_map[(1, 's')] = 0
transitions_map[(1, 'h')] = 1
transitions_map[(1, 'f')] = 3

transitions_map[(2, 'h')] = 0
transitions_map[(2, 's')] = 2
transitions_map[(2, 'f')] = 3

transitions_map[(3, 'h')] = 1
transitions_map[(3, 's')] = 0
transitions_map[(3, 'f')] = 3

start_state = 0
accept_state = {1}


d = initialize(states, alphabet, transitions_map, start_state, accept_state)
userFeelingString = d.feelingsList
print d.run(userFeelingString)
