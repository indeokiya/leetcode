type Stack struct {
    item []byte
}

func (s *Stack) Top() byte {
    return s.item[len(s.item)-1]
}

func (s *Stack) CheckAndPush(data byte) {
    if s.Length() != 0 {
        switch (data) {
        case ')':
            if s.Top() == '(' {
                s.Pop()
                return
            }
        case '}':
            if s.Top() == '{' {
                s.Pop()
                return
            }
        case ']':
            if s.Top() == '[' {
                s.Pop()
                return
            }
        }
    }
    s.item = append(s.item, data)
}

func (s *Stack) Pop() {
    s.item = s.item[:s.Length()-1]
}

func (s *Stack) Length() int {
    return len(s.item)
}


func isValid(s string) bool {
    stack := Stack{}
    
    for _, char := range s {
        stack.CheckAndPush(byte(char))
    }
    
    return stack.Length() == 0
}