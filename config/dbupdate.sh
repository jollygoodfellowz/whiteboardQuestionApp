#!/bin/bash
mongoimport --db InterviewDB --collection problemsDB --type json --file dbentries.json --jsonArray --upsertFields name
