#! /bin/bash

VERSION=4.8.8

wget https://github.com/Z3Prover/z3/releases/download/z3-$VERSION/z3-$VERSION-x64-osx-10.14.6.zip
unzip z3-$VERSION-x64-osx-10.14.6.zip

# rename folder to a generic name to make it easier to upgrade z3 versions
rm -rf z3/
mv z3-$VERSION-x64-osx-10.14.6/ z3/

# due to SIP we need to copy these libraries
sudo cp z3/bin/libz3java.dylib  /Library/Java/Extensions
sudo cp z3/bin/libz3.dylib /usr/local/lib

# add z3 to path
export PATH=$PATH:$(pwd)/z3/bin

# copy z3 jar for sbt to find
cp z3/bin/com.microsoft.z3.jar lib/
