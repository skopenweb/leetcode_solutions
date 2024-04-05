class P20ValidParan {
    public boolean isValid(String s) {
        char[] arr = new char[s.length()];
        int size = 0;
        for(char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                arr[size++] = c;
            } else {
                if (c == ')')
                    if (size > 0 && arr[size-1] == '(') {
                        size--;
                    } else {
                        size = -1;
                        break;
                    }
                else if (c == '}')
                    if (size > 0 && arr[size-1] == '{') {
                        size--;
                    } else {
                        size = -1;
                        break;
                    }
                else if (c == ']')
                    if (size > 0 && arr[size-1] == '[') {
                        size--;
                    } else {
                        size = -1;
                        break;
                    }
            }
        }
        return size == 0;
    }
}