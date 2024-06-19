// Written by Tamojit Bera, bera0041



Assumptions

    - Files from which hash tables are to be created should be present in the parent directory of src in an IntelliJ project or might have to have the filepath "src/<filename>.txt"
    - The hash function has only been tested to work correctly on String items. It might not produce desired outputs for any other type of items



Description of Hash Function

    - Converts the first 3 characters (or all characters if length of the word < 3) of the word to their corresponding ASCII values, multiplies them with each other to generate an integer (charInd)
    - Adds square of the length of the word to the generated integer
    - Mods it by length of the hash table to generate the hash value



FILE STATISTISTICS (OUTPUT)

    - "canterbury.txt"
      # unique words: 208
      # empty indices: 112
      # nonempty indices: 138
      average collision length: 1.5072463768115942
      length of longest chain: 6

    - "gettysburg.txt"
      # unique words: 150
      # empty indices: 138
      # nonempty indices: 112
      average collision length: 1.3392857142857142
      length of longest chain: 4

    - "keywords.txt"
      # unique words: 50
      # empty indices: 208
      # nonempty indices: 42
      average collision length: 1.1904761904761905
      length of longest chain: 2


    
"I certify that the information contained in this README
file is complete and accurate. I have both read and followed the course policies
in the ‘Academic Integrity - Course Policy’ section of the course syllabus."

Tamojit Bera, bera0041

