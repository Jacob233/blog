package main

import (
"fmt"
"os"
)

func main() {
	err := os.MkdirAll("E:\\pay\\MkdirTest", os.ModePerm)
	if err != nil {
		fmt.Printf("%s", err)
	} else {
		fmt.Print("Create Directory OK!")
	}
}
