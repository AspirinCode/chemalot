%mem=10GB
%nprocshared=3
%chk=id1.0036_001.chk
#T freq HF/3-21g

id1.0036_001

0 1
 C     1.1670 0.6924 -0.0383
 C     2.4135 1.4623 -0.0820
 O     3.4264 1.2746 -0.6974
 O     1.1933 -0.5056 -0.1027
 H     1.3639 -0.8697 0.7691
 H     4.0903 1.9120 -0.4242
 H     2.7392 1.4955 0.9577
 H     2.0407 2.2923 -0.6821
 H     0.5550 1.0382 -0.8714
 H     0.7971 0.8777 0.9701


--Link1--
%mem=10GB
%nprocshared=3
%chk=id1.0036_001.chk
#T Geom=AllCheck Guess=TCheck opt(readfc,ModRedundant,MaxCycles=1000)  HF/6-31g* NoSym

D 4 1 2 3  F


--Link1--
%mem=10GB
%nprocshared=3
%chk=id1.0036_001.chk
# Geom=AllCheck Guess=TCheck MP2/6-311+g**

D 4 1 2 3  F


