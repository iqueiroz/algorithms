package solution

func reverseVowels(s string) string {
	var vowels = map[byte]int{
		'a': 0,
		'e': 0,
		'i': 0,
		'o': 0,
		'u': 0,
		'A': 0,
		'E': 0,
		'I': 0,
		'O': 0,
		'U': 0,
	}
	output := make([]byte, len(s))
	lastLetter := len(s) - 1
	for i := 0; i <= lastLetter; i++ {
		output[i] = s[i]
		if _, ok := vowels[s[i]]; ok {
			for j := lastLetter; lastLetter > i; j-- {
				lastLetter = j - 1
				if _, ok := vowels[s[j]]; ok {
					output[j] = s[i]
					output[i] = s[j]
					break
				} else {
					output[j] = s[j]
				}
			}

		}
	}
	return string(output)
}
