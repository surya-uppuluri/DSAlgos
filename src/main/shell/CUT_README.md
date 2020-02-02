## CUT

####  Source file content

> 1ABCDE,FGHIJ:KLMNO"PQRSTUVQXYZ-abcdefghijklmnopqrstuvwxyz
>
> 2ABCDE,FGHIJ:KLMNO"PQRSTUVQXYZ-abcdefghijklmnopqrstuvwxyz

> 3ABCDE,FGHIJ:KLMNO"PQRSTUVQXYZ-abcdefghijklmnopqrstuvwxyz
>
> 4ABCDE,FGHIJ:KLMNO"PQRSTUVQXYZ-abcdefghijklmnopqrstuvwxyz
>
> 5ABCDE,FGHIJ:KLMNO"PQRSTUVQXYZ-abcdefghijklmnopqrstuvwxyz


### Limitations

Limitations

Cut is subject to the following limitations:

    There is no way to specify "one or more spaces" or the like as the field delimiter.
    There is no way to change the order of the fields on the output.


###  Options


| Command         | Usage                          | Example command   | output        | How it works?| Misc Info|
|----------------|-------------------------------|------------------|--------------| --- | --- |
| -c list         | prints the selected characters using tab as separator | cat src4AllEg.txt pipe cut -c 1,2,19 | 1A"\r2A"\r3A"\r4A"\r5A" | Picks 1st 2nd and 19th characters of all lines in the file| |
| -d list | Delimits the stream using given delimiter | echo a,b,c pipe cut -d, -f2,3| b,c | Delimits into 3 chars and prints 2nd and 3rd one| Has no regard for the order i.e., -3,2,1 is same as 1,2,3|
| -b list | Exact number of bytes |cut -b 1-6 src4AllEg.txt | 1AB CD\r2AB CD\r3AB CD\r4AB CD\r5AB CD| Reads input as bytes| Tabs and spaces are treated as a character of 1 byte. Also, end/start is optional E.g., cut -b 1- src4AllEg.txt is valid and prints till EO each Line|
|TODO remaining -f |


Source: [Wikibooks](https://en.wikibooks.org/wiki/Cut)