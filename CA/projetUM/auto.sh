#!/bin/bash

cd ./um;
make;
cd ../sum;
make;

cd ..;
mv ./um/um .;
mv ./sum/toSum .;
