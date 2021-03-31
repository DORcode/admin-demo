创建一个module
mkdir greetings
cd greetings

go mod init example.com/greetings

\<home\>/  
 |-- greetings/  
 |-- hello/
 
cd ..
mkdir hello
cd hello

go mod init example.com/hello

package main

import (
    "fmt"

    "example.com/greetings"
)

func main() {
    // Get a greeting message and print it.
    message := greetings.Hello("Gladys")
    fmt.Println(message)
}

由于example.com/greetings未发布，所以需要通过  
go mod edit -replace=example.com/greetings=../greetings 为了定位依赖，  

在hello 目录运行go mod tidy

go run .

greeting_test.go

go test

go test -v

go list -f '{{.Target}}'

 

 
