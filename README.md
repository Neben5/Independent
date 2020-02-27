# AP CS Independent Project: Mandelbrot set visualizer
Benjamin Kaplan, Palo Alto High School, Independent Project

github.com/Neben5/Independent

## Introduction
This is an application that will draw the mandelbrot set and colorize it. There will also be a control frame that sets zoom, color, and pan, if and when I'm able to do that.
## Fulfillments
As of yet, this only manages to draw the mandelbrot set at a set range and scale, with colorization. Zoom, color and pan need to be added. I need to add a 'header' separator to make sure that there is no gaps in the display, platform independently. The builder and runner only work for *NIX systems, but also I'm not sure I want to write a batch equivalent because windows is not something I personally support.
## Errors
No errors surprisingly, but the program is very cpu and power intensive, which threading will hopefully help, but regardless it needs to be improved.
## Overview

See Mandelbrot Layout.png. MainFrame is the entrypoint and the main window. It controls the window, mouse events, the CalcBroker, and the ControlThread.

The CalcBroker creates an array of calculator threads, that do the mandelbrot calculations and return the number of iterations and convergence/divergence, which CalcBroker, as a JComponent, draws to MainFrame.

The ControlThread has been removed. MainFrame creates a ControlFrame and passes mouseclicks from mainframe to the frame, which saves it as the dilation reference.

ControlFrame will also determine dilation and pan eventually.
## Challenges
Started with a bad class heirarchy and plan. Had to throw everything away. I was having lots of issues graphing the set originally, turns out that my magnitude and multiplication methods were not accurate, although I'm not sure how.
## Acknowledgements
Complex class based on NTU excersizes 3.1
