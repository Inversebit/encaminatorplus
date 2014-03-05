encaminatorplus
===============
A simple program to compute some data on network pathing.

Check [EncaminatorPlusGUI](https://github.com/Inversebit/encaminatorplusGUI) for a normal user user-friendly version.

Detailed description
--------------------
Given some parameters about a computer network, like dimensions, nodes per dimension, network type, message origin node and message destination node this program computes the distance between nodes, pathing register and nodes through which the message goes through.

This program is an exercise from the "Sistemas de cómputo paralelo" course from the "Facultad de Informática de San Sebastián".

Attention
---------
The program has a weird bug/feature. Hypercube networks are simulated as networks with only 2 nodes per dimension, and multiple dimensions. The pathing register is calculated as the substraction from the destination node coordinates minus the origin node coordinates, therefore negative values may appear.  
Pathing register values should be always positive in hypercubes. Just think of the negative values as positive ones to fix this bug.

License
-------
Code is licensed under the GPLv3 license. Feel free to clone, download or fork it.  
Contribution is welcomed.
