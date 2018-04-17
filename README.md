
Introduction

   The ideia for this JSON paser is to behave like XML SAX parser, generating events to handling information.

   This parser will be one way only, this means, its just get from JSON to other things, but wont get from other objects to JSON.

Motivations

   1- Speedup large JSON documents parser;
   2- Parser just keys what we need (when whe know about this keys);
   3- Flexibility using JSON as cofiguration;
   4- Getting complex objects instances from a JSON.