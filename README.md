# AP CS Independent Project: Mandelbrot set visualizer
Benjamin Kaplan, Palo Alto High School, Independent Project

github.com/Neben5/Independent

## Introduction
This is an application that will draw the mandelbrot set and colorize it. There will also be a control frame that sets zoom, color, and pan, if and when I'm able to do that.
## Fulfillments
As of yet, this manages to draw nothing but the control panel, and even then partially. It does however have a Complex class more or less completed complex class, and a determined framework.

I completely tossed out my previous work, as it was unorganized and inefficient.
I created a more standard and ubiquitous builder and packaging, such that this app could be used more broadly.
## Errors
Nothing to actually run yet, so none.
## Overview

See Mandelbrot Layout.png. MainFrame is the entrypoint and the main window. It controls the window, mouse events, the CalcBroker, and the ControlThread.

The CalcBroker creates an array of calculator threads, that do the mandelbrot calculations and return the number of iterations and convergence/divergence, which CalcBroker, as a JComponent, draws to MainFrame.

The ControlThread has been removed. MainFrame creates a ControlFrame and passes mouseclicks from mainframe to the frame, which saves it as the dilation reference.

ControlFrame will also determine dilation and framesize eventually.

It may need to be moved to be instantiated from CalcBroker, since it needs little interaction with MainFrame.
## Challenges
Started with a bad class heirarchy and plan. Had to throw everything away.
## Acknowledgements
Complex class based on NTU excersizes 3.1