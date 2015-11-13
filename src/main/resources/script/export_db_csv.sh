#!/bin/bash
echo ".headers on
select * from epp;" | sqlite3 /Users/vijay/git/DataMapper/epp.db > /Users/vijay/temp/merged/Merged.csv
