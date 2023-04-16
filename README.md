# File-to-Image
It enables you to create a image using the bytes of the file and then recreate the file using the same image. Although not encrypted it could be used to store sensitive files in a format that is not easily readable.

Download the latest version of FunctionPicture.jar from the Releases tab

Using the Jar:

- Convert File to Image: 
` java -jar FunctionPicture.jar -img [input file path] [output img path]`

- Convert back to file
` java -jar FunctionPicture.jar -file [input img path] [output file path]`
