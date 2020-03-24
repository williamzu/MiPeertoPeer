# MiPeertoPeer
Application for locating devices belonging to a P2P network using communication via UDP sockets
## Instructions
The program can be run through the MiPeertoPeer.jar file on both Linux and Windows, with only the Java v1.7 plugin should be installed.
The project has developed using the NetBeans v8.0 program, and JDK v1.7.60 was used

Specifications
UDP / Port: 12345
The identifier of each node in the P2P network is 32 bits and is generated randomly. There is an exception for duplicate identifiers on the network

Functionalities
Join: allows a new machine to participate in the network;
· Leave: allows a machine to voluntarily leave the network;
· Lookup: allows you to identify the successor to an identifier on the network;
· Update: message to update the successor;
