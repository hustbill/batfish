#!/usr/bin/env bash

. tools/batfish_functions.sh
batfish_build_all || exit 1

echo -e "\n  ..... Running parsing tests"
allinone -cmdfile test_rigs/parsing-test.cmds || exit 1

echo -e "\n  ..... Running java client tests"
allinone -cmdfile tests/java/commands || exit 1

echo -e "\n  ..... Running python client tests"
coordinator &
batfish -servicemode -register -coordinatorhost localhost -loglevel output &
pybatfish tests/python/commands.py  || exit 1

echo -e "\n .... Failed tests: "
find -name *.testout

echo -e "\n .... Diffing failed tests:"
for i in $(find -name *.testout); do echo -e "\n $i"; diff -u $i ${i%.testout}; done

#exit with exit code 1 if any test failed
if [ -n "$(find -name '*.testout')" ]; then exit 1; fi

