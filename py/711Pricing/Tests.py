import main
import unittest

class TestSumEqualsProduct(unittest.TestCase):

    def test_1(self):
        total = 4.0
        count = 2
        expected = [2.0, 2.0]
        answer = main.slurp(total, count)
        self.assertEqual(answer, expected)

    def test_2(self):
        total = 6.0
        count = 3
        expected = [1.0, 2.0, 3.0]
        answer = main.slurp(total, count)
        self.assertEqual(answer, expected)

    def test_3(self):
        total = 7.11
        count = 4
        expected = [1.20, 1.25, 1.50, 3.16]
        answer = main.slurp(total, count)
        self.assertEqual(answer, expected)

    def test_4(self):
        total = 8.0
        count = 4
        expected = [1.00, 1.00, 2.00, 4.00]
        answer = main.slurp(total, count)
        self.assertEqual(answer, expected)

    def test_5(self):
        total = 6.44
        count = 4
        expected = [1.25, 1.60, 1.75, 1.84]
        answer = main.slurp(total, count)
        self.assertEqual(answer, expected)

    def test_6(self):
        total = 5.61
        count = 3
        expected = [1.36, 1.50, 2.75]
        answer = main.slurp(total, count)
        self.assertEqual(answer, expected)

    def test_7(self):
        total = 7.98
        count = 3
        expected = [0.70, 2.28, 5.00]
        answer = main.slurp(total, count)
        self.assertEqual(answer, expected)

    def test_8(self):
        total = 7.5
        count = 3
        expected = [1.00, 1.50, 5.00]
        answer = main.slurp(total, count)
        self.assertEqual(answer, expected)

    def test_9(self):
        total = 4.05
        count = 2
        expected = [1.80, 2.25]
        answer = main.slurp(total, count)
        self.assertEqual(answer, expected)

    def test_10(self):
        total = 4.90
        count = 2
        expected = [1.40, 3.50]
        answer = main.slurp(total, count)
        self.assertEqual(answer, expected)

    def test_11(self):
        total = 8.41
        count = 2
        expected = [1.16, 7.25]
        answer = main.slurp(total, count)
        self.assertEqual(answer, expected)


if __name__ == '__main__':
    unittest.main()
