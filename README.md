# AP CS Independent Project: Mandelbrot set visualizer
Benjamin Kaplan, Palo Alto High School, Independent Project

github.com/Neben5/Independent

## Introduction
This is an application that will draw the mandelbrot set and colorize it. There ia also a control frame that sets zoom, color, and pan.
## Fulfillments
As of yet, this only manages to draw the mandelbrot set at a set range and scale, with colorization, zoom, color and pan. I need to add a 'header' separator to make sure that there is no gaps in the display, platform independently. The builder works for *NIX systems, but also I'm not sure I want to write a batch equivalent because windows is not something I personally support. Either way, you can execute them with the git terminal if on windows. Note that the builder now creates an executable jar, that can be executed as a normal application. Threading needs to be added, as window sizes abover 640:600 cause a decent delay when resizing the window on my 5-7 year old macbook air 13 inch. I know it's not a great processor, but also there's no reason it should be so cpu-heavy.
## Errors
No errors surprisingly, but the program is very cpu and power intensive, which threading will hopefully help, but regardless it needs to be improved. Note that the main branch has many, mostly pertaining to the threading.
## Overview

See Mandelbrot Layout.png. MainFrame is the entrypoint and the main window. It controls the window, mouse events, the CalcBroker, and the ControlThread.

The CalcBroker creates an array of calculator threads, that do the mandelbrot calculations and return the number of iterations and convergence/divergence, which CalcBroker, as a JComponent, draws to MainFrame.

The ControlThread has been removed. MainFrame creates a ControlFrame and passes mouseclicks from mainframe to the frame, which saves it as the dilation reference.

ControlFrame will also determine dilation and pan eventually.
## Challenges
Started with a bad class heirarchy and plan. Had to throw everything away. I was having lots of issues graphing the set originally, turns out that my magnitude and multiplication methods were not accurate, although I'm not sure how. Threading is difficult, and lambdas are a bit funky, so getting to understand all these things took some time.
## Acknowledgements
Complex class based on NTU excersizes 3.1
